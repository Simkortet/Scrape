namespace Shared

open System

module SdarmLesson =
    type Id = SdarmLessonId of Guid
    type Title = SdarmLessonTitle of string
    type Number = SdarmLessonNumber of int
    type Date = SdarmLessonDate of DateOnly

    type SectionTitle = SectionTitle of string
    type WeekDay =
        | Sunday of string
        | Monday of string
        | Tuesday of string
        | Wednesday of string
        | Thursday of string
        | Friday of string
        | Sabbath of string

    type Month =
        | January
        | February
        | March
        | April
        | May
        | June
        | July
        | August
        | September
        | October
        | November
        | December

    type DayNumber = DayNumber of int

    type SectionDay = { WeekDay: WeekDay; MonthName: Month; DayNumber: DayNumber}

    type Book = Book of string
    type Chapter = Chapter of int
    type VerseNumber = VerseNumber of int

    type ChapterVerse = { Chapter: Chapter; VerseNumbers: VerseNumber list}

    type BibleText = { Book: Book; ChapterVerses: ChapterVerse list}

    type Text = Text of string
    type PageNumber = PageNumber of int
    type SOPBookReference = { Book: Book; PageNumbers: PageNumber list }
    type Comment = { Text: Text; Reference: SOPBookReference }

    type Question = {
        Question: string
        BibleTexts: BibleText list
        Comments: Comment list
    }

    type Section = { Day: SectionDay; Title: SectionTitle; Questions: Question list; SuggestedReading: SOPBookReference option}

    type Year = Year of int

    type ReviewNumber =
        | One
        | Two
        | Three
        | Four
        | Five
    type ReviewQuestion = { ReviewQuestion: string; Number: ReviewNumber}
    type FridaySection = { Day: SectionDay; ReviewQuestions: ReviewQuestion list }

    type Url = Url of string


[<CLIMutable>]
type SdarmLesson = {
    Id: SdarmLesson.Id
    Number: SdarmLesson.Number
    SabbathSection: SdarmLesson.Section
    Year: SdarmLesson.Year
    Title: SdarmLesson.Title
    Sections: SdarmLesson.Section list
    FridaySection: SdarmLesson.FridaySection
    Url: SdarmLesson.Url
}

type ISdarmLessonApi = {
    scrape: unit -> Async<SdarmLesson list>
}
