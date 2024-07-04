<h1>Foro Hub Challenge</h1>
<img src="https://img.shields.io/badge/Status%20-%20Finished%20-%20Green?style=flat&color=green">
Welcome to Kiwi Forum! an API Rest based on the Alura Forum but for cats where they can post questions and interact with each other on various topics related to their feline lives and courses. 
<img src="https://media.discordapp.net/attachments/1014298027638403082/1258477700763615333/kiwiforum.png?ex=66883031&is=6686deb1&hm=d1243d45bc90d0c136826e96db73b8ce0155ee95704c37962db5aa20078bed15&=&format=webp&quality=lossless&width=1014&height=676">
<h2>FEATURES</h2>
<ul>
  <li>User registration and login functionality.</li>
  <li>Cats can post questions with titles, messages and questions about the courses they are partaking in.</li>
  <li>Forum topics can be marked with statuses like "OPEN" for ongoing discussions and "CLOSED" for finished discussions.</li>
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
  <li><b>POST /login:</b> Authenticate and generate a JWT token.</li>
</ul>
<img src="[https://media.discordapp.net/attachments/1014298027638403082/1258458651459321909/image.png?ex=66881e73&is=6686ccf3&hm=90b19129a78f9b74de9df3c03115fa73cfe9d083c05b43089a70df43cba462a9&=&format=webp&quality=lossless](https://media.discordapp.net/attachments/1014298027638403082/1258463205605507123/image.png?ex=668822b1&is=6686d131&hm=3711eac37570d3b834ff4d7b7b7a798ee49cd79df11e196ca5f086dd9c62e862&=&format=webp&quality=lossless)">
<h3>FORUM POSTS</h3>
<ul>
   <li><b>POST /topic:</b> Create a new topic.</li>
  <img src="https://media.discordapp.net/attachments/1014298027638403082/1258463545553846343/image.png?ex=66882302&is=6686d182&hm=63ceca32fddb2ebed200b2b9261ac22d4378659d6473620b35cdd57b8e3b9e40&=&format=webp&quality=lossless">
  <li><b>GET /topic/list:</b> Retrieve all topics.</li>
  <img src="https://media.discordapp.net/attachments/1014298027638403082/1258464583639629885/image.png?ex=668823f9&is=6686d279&hm=e502486bd831af715cf1bfe42828e3efc564725189274b7a5368d9dee21132b2&=&format=webp&quality=lossless&width=852&height=676">
  <li><b>PUT /topic/{id}:</b> Edit and update a specific topic.</li>
  <img src="https://media.discordapp.net/attachments/1014298027638403082/1258465697122746500/image.png?ex=66882503&is=6686d383&hm=6b158047fd1fed7aa11efb31bc8f4e02a8a8fa7a385e1dcd568dda4cd55bce83&=&format=webp&quality=lossless">
  <li><b>DEL /topic/delete/{id}</b> Delete topic with the choice to delete or not from the database.</li>
  <li><b>GET /topics/{id}:</b> Retrieve a specific topic by ID.</li>
  <img src="https://media.discordapp.net/attachments/1014298027638403082/1258466034646777927/image.png?ex=66882553&is=6686d3d3&hm=cb00e32cf0d96e45dcfc10490de6866a461addc8be2f1819ce67713c184b2f2e&=&format=webp&quality=lossless">
  
</ul>
<h3>ERROR HANDLING</h3>
<ul>
  <li>Custom error messages and HTTP status codes are returned for invalid requests.</li>
</ul>
