printjson(db.people.mapReduce(
  function () {
    var value = {
      weight: parseFloat(this.weight),
      height: parseFloat(this.height),
      count: 1
    };
    emit(this.sex, value);
  },
  function (key, values) {
    var results = {
      weights: 0,
      heights: 0,
      count: 0
    };

    values.forEach(value => {
      results.weights += value.weight;
      results.heights += value.height;
      results.count += value.count;
    });

    return results;
  },
  {
    out: { inline: 1 },
    finalize: function (key, value) {
      return {
        sex: key,
        weightAverage: value.weights / value.count,
        heightAverage: value.heights / value.count
      }
    }
  }
));