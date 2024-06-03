Purpose: The purpose of this application is to keep track of different Event types.

Current state: The current state of the app offers basic CRUD functionality with a SQL DB.

Future state/improvements: The future state of the app should contain a Person class to keep track of a user's profile information.
There should be a PersonProfile class, an events attending list, and an events owned list to store the events the user has created.
Person would have a many-to-many relationship with Event via events attending list. It would have a one-to-many relationship
with Event.java via the events owned list.
