# android-test-2.0

Hello! Thank you for taking the time to try our Android test. The goal of the test is to assess your coding and design skills. You will have to complete two exercises — design a simple implementation of the Menu Feature (Exercise 1) and create a simple single-page application showcasing the recipes (Exercise 2).

**Note 1:** Exercise 1 and Exercise 2 are not related in any way and should be handled separately.

**Note 2:** While we love open source here at HelloFresh, please do not create a public repo with your test in! This challenge is only shared with people interviewing, and for obvious reasons, we'd like it to remain this way.

### Instructions

- Clone this repo.
- Create a new dev branch.
- Implement Exercise 1 in the `task1` module, and Exercise 2 in the `task2` module.
- Create a pull request against the master branch of this repo.
- After creating your pull request, please send the link via email to our HR department in order for us to start the reviewing process.

### Tips on How to Tackle the test

- Schedule a specific time to tackle the test.
- Be well rested and choose a quiet place with no interruptions.
- Read the instructions and requirements carefully, and feel free to ask any questions.
- Identify technical decisions you need to make and sketch out an initial plan.
- Start coding and commit often.
- Please consider Clean Code Principles.
- Enrich the code with comments and include clear instructions.

## Exercise I - Menu Code Kata

### Initial configuration

The idea of the first exercise is to design a simple implementation of a Menu feature based on the requirements listed below. Technical implementation is up to you, but all decisions should be listed in the README file with a short description of the reasonings.  We don't expect you to invest more than 2 hours on this exercise.

For the purpose of this task we will assume the following:<br/> 
A Recipe is a data structure with an id, title, and a list of tags associated with it. Examples of tags can be "hot", "quick", "low-calories", etc. Recipes are equal if their ids are equal. A Subscription is a data structure with id, delivery day, and isForFamily properties.

You will be creating and adding behaviors to a Menu model:

- A list of recipes available for selection is provided to the menu. 
- Menu exposes a list of recipes available for selection.
- Menu has a reference to an associated subscription.

### Requirements

- Keep SOLID principles in mind while you are working on this exercise
- Do not develop any UI for this exercise
- Unit and/or integration tests should be part of this exercise

**Selecting recipes in the menu**

- You should be able to mark a single recipe as selected.
- You should be able to mark multiple recipes as selected.
- You should be able to ask the menu how many recipes have been selected.

**Unselecting recipes in the menu**

- You should be able to unselect a single selected recipe.
- You should be able to unselect multiple selected recipes.

**Accessing recipes in the menu**

- You should be able to request a list of selected recipes.
- You should be able to request a list of recipes which have a certain tag.

**Restricting the behavior**

- You should not be able to select more than 3 recipes.

**Modifying the behavior based on subscription type**

- You should be able to select up to 5 recipes if the subscription is for a family.
 
*Note*

- Don’t forget to notify calling code about errors where appropriate.
- The Recipe data structure is final. Please do not add more properties to it.
 
 
## Exercise II -  Recipes List View 


The idea of the second exercise is to create a simple single-page application showcasing the recipes. Please treat this as a production code and feel free to choose design patterns you are comfortable with. We don't expect you to invest more than 3 hours on this exercise. 

### Requirements

- Build a single view application that shows a list of recipes. 
- Implement data loading, basic UI, error handling. 
- Keep in mind code readability, scalability, and maintainability when making implementation decisions. 
- Provide README with justifications and testing strategies. 

The list of recipes should be loaded via HTTP request using this link - [recipes.json](https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/recipes.json)

**There is no need to build:**<br/>

- Stylish UI, basic and readable is enough,
- Navigation,
- Caching,
- Write UI or unit tests.

**User Interface**

- The app should show a single view.
- At launch, the app should show a loading spinner while it gets the data from the source. 
- When the data is fetched, the app should hide the loading spinner and show the recipes’ view.
- Show the current date in “dd  MMM” format (20 Aug) with text size 18sp as a first element of the recipes list view.
- Recipes in the list are presented as cards with image, title and headline. Title should be in bold with text size 16sp.
- If an error occurred, you should show a snackbar with a short description of the issue.

**Sample JSON**

[
  {
    "calories": "516 kcal",
    "carbos": "47 g",
    "description": "There\u2019s nothing like the simple things in life - the smell of freshly cut grass, sitting outside on a nice sunny day, spending time with friends and family. Well here is a recipe that delivers simple culinary pleasures - some nice fresh fish with a crispy crust, crunchy potato wedges and some delightfully sweet sugar snap peas flavoured with cooling mint. Slip into something comfortable and relax into a delicious dinner!",
    "difficulty": 0,
    "fats": "8 g",
    "headline": "with Sweet Potato Wedges and Minted Snap Peas",
    "id": "533143aaff604d567f8b4571",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/533143aaff604d567f8b4571.jpg",
    "name": "Crispy Fish Goujons ",
    "proteins": "43 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/533143aaff604d567f8b4571.jpg",
    "time": "PT35M"
  },
  {
    "calories": "397 kcal",
    "carbos": "26 g",
    "description": "Close your eyes, open up your Ras El Hanout and inhale deeply. You are no longer standing in your kitchen. Around you are the sounds of a bustling market. Robed men sell ornate carpets and a camel nibbles affectionately at your ear.  OK, we\u2019re pretty sure Paul McKenna\u2019s job is safe for now, but get cooking this recipe and take dinnertime on a magic carpet ride to Casablanca! Our tip for this recipe is to take your meat out of the fridge at least 30 minutes before dinner which will allow you to cook it more evenly.",
    "difficulty": 0,
    "fats": "5 g",
    "headline": "with Spinach and Lemon Couscous",
    "id": "53314247ff604d44808b4569",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/53314247ff604d44808b4569.jpg",
    "name": "Moroccan Skirt Steak ",
    "proteins": "31 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314247ff604d44808b4569.jpg",
    "time": "PT30M"
  },
  {
    "calories": "458 kcal",
    "carbos": "29 g",
    "description": "World-renowned people generally all have one thing in common: a legacy. For Henry Ford it was the motorcar, for Thomas Edison it was the lightbulb. For our intern Simon, it was this lip-smackingly awesome Sea Bream. Taking the warm crunchiness of potatoes against the fresh southern asian flavours of fish with coriander, ginger and lime, it\u2019s the perfect dish for transporting your tastebuds. Don\u2019t let the smell of the fish sauce throw you - add it gradually to your sauce for a really authentic asian spin!",
    "difficulty": 1,
    "fats": "6 g",
    "headline": "with Tomato Concasse and Crispy Potatoes",
    "id": "53314276ff604d28828b456b",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/53314276ff604d28828b456b.jpg",
    "name": "Simple Sumptuous Sea Bream",
    "proteins": "29 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314276ff604d28828b456b.jpg",
    "time": "PT35M"
  },
  {
    "calories": "717 kcal",
    "carbos": "44 g",
    "description": "Nostalgia is a powerful thing. For some it\u2019s triggered by the smell of freshly cut grass, for others by the sound of a love song from their heady teenage years. For Head Chef Patrick it\u2019s all about Swiss Roll. A firm dinnertime favourite from his primary school years, we still see him go all misty eyed at the mere mention of it. We\u2019re pretty sure that was the inspiration behind this little number. Tonight, prepare to create a little nostalgia that the little \u2018uns will remember for years!",
    "difficulty": 2,
    "fats": "10 g",
    "headline": "with Roasted Rocket Potatoes",
    "id": "533143bfff604d44808b456a",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/533143bfff604d44808b456a.jpg",
    "name": "Mozzarella and Pesto Roulades",
    "proteins": "67 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/533143bfff604d44808b456a.jpg",
    "time": "PT35M"
  },
  {
    "calories": "751 kcal",
    "carbos": "105 g",
    "description": "Head Chef Patrick doesn\u2019t like fuss. He\u2019s always telling us that the best kind of food is simple, soulful grub that makes you feel loved. That said, every dinner is a chance to practice your presentation skills. Bigger plates are a great way of framing your food and a sprinkle of herbs or a drizzle of olive oil at the end gives everything a bit more pizzazz. For this recipe, we took classic Mexican ingredients and played with the presentation to create something that\u2019s as tasty to the eye as it is to the tongue. Arriba!",
    "difficulty": 1,
    "fats": "4 g",
    "headline": "with Homemade Guacamole and Black Bean Salsa",
    "id": "5331430fff604d557f8b456d",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/5331430fff604d557f8b456d.jpg",
    "name": "Mexican Tortilla Stack",
    "proteins": "35 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/5331430fff604d557f8b456d.jpg",
    "time": "PT35M"
  },
  {
    "calories": "689 kcal",
    "carbos": "84 g",
    "description": "We\u2019ve all heard that much overused culinary phrase \u201cfusion food\u201d, but this recipe is fusion of a slightly different kind. With the onset of Winter Patrick has taken some decidedly seasonal squash and the deep, heady scent of rosemary and combined them with the lighter flavour of feta and wild rice. The squash takes a little bit of work with a vegetable peeler but once you\u2019ve tackled and roasted it you\u2019ll never look back. We use any leftovers for butternut squash soup!",
    "difficulty": 0,
    "fats": "8 g",
    "headline": "with Wild Rice, Feta and Pine Nuts",
    "id": "53314328ff604d4d808b456b",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/53314328ff604d4d808b456b.jpg",
    "name": "Roasted Rosemary Butternut Squash ",
    "proteins": "23 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314328ff604d4d808b456b.jpg",
    "time": "PT40M"
  },
  {
    "calories": "",
    "carbos": "",
    "description": "\u2018Allo Genovese\u2019 simply means \u2018in the style of Genoa\u2019, which is the northern Italian city famous for the pesto that you\u2019ll be making tonight. \u2018Pesto\u2019 actually comes from the word \u2018pestare\u2019, which means to pound or crush, referring to the old fashioned method of making it in a pestle & mortar. If you happen to have a food processor, you can whizz the pesto together in that, or alternatively just chop, chop, chop everything until it is tiny. Andiamo! ",
    "difficulty": 0,
    "fats": "",
    "headline": "with Toasted Pine Nuts and Tenderstem Broccoli",
    "id": "53314343ff604d28828b456c",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/53314343ff604d28828b456c.jpg",
    "name": "Gnocchi Allo Genovese",
    "proteins": "",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314343ff604d28828b456c.jpg",
    "time": "PT25M"
  },
  {
    "calories": "790 kcal",
    "carbos": "100 g",
    "description": "\u201cPolpetti?!\u201d we hear you say. That\u2019s meatballs to you and me. But meatballs so good you want \r\n\r\nto parade them down the street waving your arms aloft like a passionate Italian grandmother. \r\n\r\nThese little rascals are perfect for your little rascals (both big and small!) as you can get \r\n\r\neveryone involved in rolling them up. Once served, everyone around the table must choose an \r\n\r\nItalian name and act Italian for the rest of dinner time. Andiamo!*",
    "difficulty": 3,
    "fats": "9 g",
    "headline": "with Creamy Parmesan Polenta",
    "id": "53314398ff604d6c7a8b456a",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/53314398ff604d6c7a8b456a.jpg",
    "name": "Herbed Italian Polpetti",
    "proteins": "39 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/53314398ff604d6c7a8b456a.jpg",
    "time": "PT35M"
  },
  {
    "calories": "556 kcal",
    "carbos": "62 g",
    "description": "Patrick has been working on a theory that the fewer utensils you use to eat a meal, the tastier it\u2019s likely to be. Think about it - everything you eat with only a fork is usually delicious. Dispense with cutlery entirely to use your fingers and suddenly you\u2019re in taste bud paradise. That was the thinking behind this Japanese favourite. A surefire winner in the eateries of Tokyo, pick it up with your fingers and get stuck in! The first person to finish has to shout \u201cBanzaaaiiii\u201d!",
    "difficulty": 2,
    "fats": "4 g",
    "headline": "and Sweet and Sour Noodles",
    "id": "5252b20c301bbf46038b477e",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/5252b20c301bbf46038b477e.jpg",
    "name": "Genki Yakitori with Crispy Red Onions",
    "proteins": "32 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/5252b20c301bbf46038b477e.jpg",
    "time": "PT40M"
  },
  {
    "calories": "751 kcal",
    "carbos": "105 g",
    "country": "GB",
    "description": "Head Chef Patrick doesn\u2019t like fuss. He\u2019s always telling us that the best kind of food is simple, soulful grub that makes you feel loved. That said, every dinner is a chance to practice your presentation skills. Bigger plates are a great way of framing your food and a sprinkle of herbs or a drizzle of olive oil at the end gives everything a bit more pizzazz. For this recipe, we took classic Mexican ingredients and played with the presentation to create something that\u2019s as tasty to the eye as it is to the tongue. Arriba!",
    "difficulty": 0,
    "fats": "4 g",
    "headline": "with Cucumber Salad",
    "id": "5331430fff604d557f8b456c",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/sausage-risotto-wk41-a201d2fa.jpg",
    "name": "Sausage Risotto",
    "proteins": "35 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/sausage-risotto-wk41-a201d2fa.jpg",
    "time": "PT35M"
  },
  {
    "calories": "689 kcal",
    "carbos": "84 g",
    "description": "We\u2019ve all heard that much overused culinary phrase \u201cfusion food\u201d, but this recipe is fusion of a slightly different kind. With the onset of Winter Patrick has taken some decidedly seasonal squash and the deep, heady scent of rosemary and combined them with the lighter flavour of feta and wild rice. The squash takes a little bit of work with a vegetable peeler but once you\u2019ve tackled and roasted it you\u2019ll never look back. We use any leftovers for butternut squash soup!",
    "difficulty": 0,
    "fats": "8 g",
    "headline": "with Peppercorn Sauce (F)",
    "id": "53314328ff604d4d128b456b",
    "image": "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/54511c31ff604dee7b8b4571.jpg",
    "name": "Bacon Wrapped Pork Loin ",
    "proteins": "23 g",
    "thumb": "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/54511c31ff604dee7b8b4571.jpg",
    "time": "PT40M"
  }
]
