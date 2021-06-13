import com.fasterxml.jackson.databind.ObjectMapper;
import model.BankAccount;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


public class Startup {

    private final static OkHttpClient client = new OkHttpClient();
    private final static String BASE_URL = "http://localhost:8098/buckets/";
    private final static String BUCKET_NAME = "clients";

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        var johnDoe = new BankAccount(
                UUID.randomUUID().toString(),
                "John Doe",
                "5201430470369401",
                10005.65
        );

        storeObject(johnDoe);
        var johnDoeRetrieved = getObject(johnDoe.getId());
        johnDoeRetrieved.setBalance(johnDoe.getBalance() - 5000);
        System.out.println("John Doe balance modified to " + johnDoeRetrieved.getBalance());
        storeObject(johnDoeRetrieved);
        var johnDoeModified = getObject(johnDoeRetrieved.getId());
        removeObject(johnDoe.getId());
        getObject(johnDoeModified.getId());
    }

    private static void storeObject(BankAccount object) throws IOException {
        System.out.println("Storing object with ID " + object.getId());
        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(object);
        var requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                json
        );
        var request = new Request.Builder()
                .url(BASE_URL + BUCKET_NAME + "/keys/" + object.getId())
                .put(requestBody)
                .build();
        var call = client.newCall(request);
        var response = call.execute();

        if (response.code() != 204) {
            System.out.println("Storing object failed!");
            System.out.println(new String(response.body().bytes()));
            throw new IOException();
        }
    }

    private static BankAccount getObject(String id) throws IOException {
        System.out.println("Fetching object with ID " + id);
        var request = new Request.Builder()
                .url(BASE_URL + BUCKET_NAME + "/keys/" + id)
                .build();

        var call = client.newCall(request);
        var response = call.execute();

        if (response.code() == 200 && response.body() != null){
            System.out.println("Fetching succeeded!");
            var responseBodyJson = new String(response.body().bytes());
            var objectMapper = new ObjectMapper();
            var convertedObject = objectMapper.readValue(responseBodyJson, BankAccount.class);
            System.out.println("Object fetched: \n" + convertedObject);
            return convertedObject;
        }
        else if (response.code() == 404) {
            System.out.println("Can't find item with ID: " + id);
            return null;
        }
        else {
            System.out.println("Fetching item failed!");
            throw new IOException();
        }
    }

    private static void removeObject(String id) throws IOException {
        System.out.println("Removing object with ID " + id);
        var request = new Request.Builder()
                .url(BASE_URL + BUCKET_NAME + "/keys/" + id)
                .delete()
                .build();

        var call = client.newCall(request);
        var response = call.execute();

        if (response.code() == 204) {
            System.out.println("Object removed successfully!");
        }
        else {
            System.out.println("Can't remove object.");
            throw new IOException();
        }
    }
}
