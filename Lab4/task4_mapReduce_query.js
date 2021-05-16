printjson(
    db.people.mapReduce(
        function () {
            var numericWeight = parseFloat(this.weight);
            var numericHeight = parseFloat(this.height) / 100;

            var result = {
                bmi: numericWeight / (numericHeight * numericHeight), 
                count: 1
            };

            emit(this.nationality, result);
        },
        function (key, values) {
            var bmis = values.map(value => value.bmi);
            var minBmi = Math.min(...bmis);
            var maxBmi = Math.max(...bmis);

            var bmiSum = 0;
            var count = 0;

            values.forEach(value => {
                bmiSum += value.bmi;
                count += value.count;
            })

            return {
                minBmi,
                maxBmi,
                bmiSum,
                count
            };
        },
        {
            out: { inline: 1 },
            finalize: function(key, value) {
                return {
                    sex: key,
                    minBmi: value.minBmi,
                    maxBmi: value.maxBmi,
                    bmiAverage: value.bmiSum / value.count
                }
            }
        }
    )
);