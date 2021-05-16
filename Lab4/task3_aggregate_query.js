printjson(
    db.people.aggregate(
        [
            {
                $group: {
                    _id: "jobs",
                    uniqueJobs: { $addToSet: "$job" }
                }
            }
        ]
    ).toArray()
);