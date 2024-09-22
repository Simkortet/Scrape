module Server.Sdarm

open LiteDB
open LiteDB.FSharp
open Shared

let database =
        let mapper = FSharpBsonMapper()
        let connectionString = "Filename=SdarmLesson.db"
        new LiteDatabase (connectionString, mapper)

let sdarmLessons = database.GetCollection<SdarmLesson>

let scrape =
    let baseUrl = "https://sdarm.org/publications/periodicals/sbl/en/"
    []

let getDocument =

