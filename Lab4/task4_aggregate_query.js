printjson(
    db.people.aggregate(
        [
            {
                $addFields: {
                    numericWeight: { $toDouble: "$weight" },
                    numericHeight: { $toDouble: "$height" },
                }
            },
            {
                $addFields: {
                    metricHeight: { $divide: ["$numericHeight", 100] },
                }
            },
            {
                $addFields: {
                    doubledHeight: { $multiply: ["$metricHeight", "$metricHeight"] }
                }
            },
            {
                $project: {
                    nationality: "$nationality",
                    bmi: { $divide: ["$numericWeight", "$doubledHeight"] }
                }
            },
            {
                $group:
                {
                    _id: "$nationality",
                    averageBmi: { $avg: "$bmi" },
                    minBmi: { $min: "$bmi" },
                    maxBmi: { $max: "$bmi" }
                }
            }
        ]).toArray()
);