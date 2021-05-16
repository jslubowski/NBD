db.people.aggregate(
   [
    {
  $group : {
    _id: "$sex",
    averageHeight: { $avg: { $toDouble: "$height" } },
    averageWeigth: { $avg: { $toDouble: "$weight" } },
  }
}
]).toArray();