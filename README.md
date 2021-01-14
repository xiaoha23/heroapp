API: /hero

verb: GET

Request:

Expected Http Status:
    200,
    204

Response:
    [{"name": "superman"},
     {"name": "spiderman"}
    ]

Exception:
    {}






As a visitor, I can view all the heroes.

When I view all the heros
Then I can see names of all heros

------------------

As a visitor, I can see information about any individual hero so that I can see their stats.

Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.

Given I have the name of a hero
When I retreive the hero
Then I can view all the details for that hero


Given I have an incorrect hero name
When I retreive details for that hero
Then I receive a message that it doesn't exist

API: /hero/{name}

verb: GET

Request:

Expected Http Status:
200,
404

Response:
{
"image":"photo",
"realname":"Mike Smith",
"heroname":"spiderman",
"height":"6",
"weight":"140",
"specialpower":"magic",
"intelligence":"High",
"strength":"Strong",
"power":"horse",
"speed":"127",
"agility":"VeryHigh",
"description":"Breif Bio",
"story":"Simple Story"
}


Exception:

{
"errormsg":"Hero Not Available"
}



