module Server

open SAFE
open Saturn
open Shared

let sdarmApi ctx = {
    scrape = fun () -> async { return Server.Sdarm.scrape }
}

let webApp = Api.make sdarmApi

let app = application {
    use_router webApp
    memory_cache
    use_static "public"
    use_gzip
}

[<EntryPoint>]
let main _ =
    run app
    0