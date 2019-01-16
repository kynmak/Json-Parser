# Json-Parser
Json-Parser is an Android application that receives and displays JSON formatted data into a RecyclerView. 
<br />
<br/>
This was done by opening a http url connection to a given url, and using BufferedReader to read the input stream. Once the data is received, 
it is printed as requested. The JSON objects are then parsed in an AsyncTask into "Destination" objects, which hold 
information needed from the JSON objects. Once the information is extracted, the data is displayed on a RecyclerView using a custom adapter, ListAdapter during onPostExecute(). 
The data includes the name, city, state, end date, as well as an image (from a url) of each given data object. 
### Technical Choices
Currently the server of the given url does not provide city or state values within "venue", meaning that the city and state
of an object does not display. As such "venue's" JSON object is checked for objects "city" and "state" before adding the data to a Destination object since the values in the url may be added in the future. 
A placeholder value of "city" and "state" are used instead. The milestones are met otherwise. 
<br/>
<br/>
Picasso library (http://square.github.io/picasso/) was used in order to easily load an image from an url in one line of code.
<br/>
<br/>
StringBuilder is preferred when receiving data instead of a String for efficiency as the input stream is read line by line. 
<br/>
<br/>
Destination class holds variables that were described in "Guide" objects. Not all of the data is used; however, it may be 
useful to have in future builds. 
<br/>
<br/>
An ImageButton was used to display the image as a future implementation may like options when clicking on the image. 
<br/>
<br/>
RelativeLayout was preferred as a LinearLayout was used for the RecyclerView. 
### Future Plans
Redesigning the UI would be a priority, as the current UI is only made to display basic data. Adding more variables in 
the Destination class to hold, as there are a few data in "Guide" objects that are not in use but may be important. 
As an extension to the original problem, clicking on the view to display additional details about each event/location.
