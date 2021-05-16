printjson(
    db.people.mapReduce(
        function () {
            if (this.sex === "Female" && this.nationality === "Poland") {
                this.credit.forEach(credit =>
                    emit(credit.currency, {
                        balance: parseFloat(credit.balance),
                        count: 1
                    })
                );
            }
        },
        function (key, values) {
            var totalBalance = 0;
            var count = 0;

            values.forEach(value => {
                totalBalance += value.balance;
                count += value.count;
            });

            return {
                totalBalance,
                count
            }
        },
        {
            out: { inline: 1 },
            finalize: function(key, value) {
                return {
                    currency: key,
                    averageBalance: value.totalBalance / value.count,
                    totalBalance: value.totalBalance
                }
            }
        }
    )
);