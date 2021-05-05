use('nbd');

db.people.remove(
  {
    height: { $gte: "190" },
  }
)
