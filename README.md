<h1>Foro Challenge</h1>
<img src="https://img.shields.io/badge/Status%20-%20Finished%20-%20Green?style=flat&color=green">
Kiwi Forum is a forum application based on the Alura Forum but for cats where they can post questions and interact with each other on various topics related to their feline lives. 
Courses offered: "How to be a well behaved cat" "WORLD DOMINATION"
<img src="">
<h2>FEATURES</h2>
<ul>
  <li>User registration and login functionality.</li>
  <li>Cats can post questions with titles, messages and questions about the courses they are partaking in.</li>
  <li>Forum topics can be marked with statuses like "OPEN" for ongoing discussions.</li>
  <li>Authentication with JWT tokens for secure access to API endpoints.</li>
</ul>

<h2>TECHNOLOGIES USED:</h2>
<ul>
<li>JDK 17</li>
<li>Spring boot</li>
<li>Spring security</li>
<li>Maven</li>
<li>JWT (JSON Web Tokens)</li>
<li>MySQL</li>
<li>IntelliJ IDEA Community Edition</li>
      </ul>

<h2>API ENDPOINTS</h2>
<h3>AUTHENTICATION</h3>
<ul>
  <li>POST /login: Authenticate and generate a JWT token.</li>
</ul>
<img src="">
<h3>FORUM POSTS</h3>
<ul>
   <li>POST /topic: Create a new topic.</li>
  <li>GET /topic/list: Retrieve all topics.</li>
  <li>PUT /topic/{id}: Edit and update a specific topic.</li>
  <li>DEL /topic/delete/{id}: Delete topic with the choice to delete or not from the database.</li>
  <li>GET /topics/{id}: Retrieve a specific topic by ID.</li>
  
</ul>
<h3>ERROR HANDLING</h3>
