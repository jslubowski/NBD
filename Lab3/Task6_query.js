use('nbd');

db.people.insert({
  sex: "Male",
  first_name: "Jakub",
  last_name: "Ślubowski",
  job: "Junior Software Developer",
  email: "jslubowski@github.com",
  location: {
    city: "Warsaw",
    address: {
      streetname: "Krakowskie Przedmieście",
      streetnumber: "48/50"
    }
  },
  description: "ac nibh fusce lacus purus aliquet at feugiat non pretium quis",
  height: 178,
  weight: 71,
  birth_date: "1996-25-01T18:35:37Z",
  nationality: "Poland",
  credit: [
    {
      type: "mastercard",
      number: "5555666677778888",
      currency: "PLN",
      balance: "0.55"
    },
  ]
})
