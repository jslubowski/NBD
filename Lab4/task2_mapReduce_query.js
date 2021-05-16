printjson(
    db.people.mapReduce(
        function () {
            this.credit.forEach(element => {
                emit(element.currency, parseFloat(element.balance));
            });
        },
        function (key, values) {
            return Array.sum(values);
        },
        {
            out: { inline: 1 },
            finalize: function(key, value) {
                return {
                    currency: key,
                    sum: value
                }
            }
        }
    )
);