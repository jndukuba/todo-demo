# Pre-work - *Honey Due*

**Honey Due** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: John Ndukuba

Time spent: 1 hour spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file

## Video Walkthrough

Here's a walkthrough of implemented user stories:

[Link to Video Walkthrough](https://www.dropbox.com/s/42eik69tietztec/todo.mp4?dl=true)

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** I like it so far. I'm still working my way through the framework to get a true feel of what's available to me. The concept of intents are straight forward and implicit intents seems like a powerful
tool though I'm curious on how Android manages the total number of activities that could respond to an implicit intent. 

Android's approach to layouts reminds me of Flex's XML-based layouts. The ability to make layout changes without touching a line of code is great. Separating the concern of the UI from behavior implementations will be fruitful in the future while maintaining the application and adding new features.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** The adapter is a proxy to different types of collections. I believe it's important since it can provide a common interface to a collection while allowing a developer to switch collection implementations based on application need. `convertView` makes it possible to reuse a View that's already been instantiated rather than to create a new View every time one is needed and to use a use a custom view for complex data types. 

## Notes

None so far. Documentation has been fairly thorough

## License

    Copyright 2017 John Ndukuba

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
