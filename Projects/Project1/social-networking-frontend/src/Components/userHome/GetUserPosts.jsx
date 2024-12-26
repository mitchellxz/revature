import { useEffect, useState } from "react";
import axios from "axios";
import CardPostComponent from "./CardPostComponent";

function GetUserPosts() {
  const profileId = sessionStorage.getItem("profile_id");
  const [posts, setPosts] = useState(null);
  const url = `http://localhost:8080/post/${profileId}/all`;
  const config = {
    withCredentials: true,
    headers: {
      "Content-Type": "application/json",
    },
  };

  useEffect(() => {
    async function getPosts() {
      try {
        const response = await axios.get(url, config);
        console.log(response.data);
        setPosts(response.data);
      } catch (error) {
        console.error("Error fetching posts: ", error);
      }
    }
    getPosts();
  }, []);
  if (!posts) {
    return <p>Loading posts...</p>;
  }

  return (
    <div>
      <ul>
        {posts.map((post) => (
          <div key={post.id}>
            <CardPostComponent
              name={post.profileFullName}
              postTitle={post.content}
              messages={post.messages}
              postDate={post.createdAt}
              likes={post.likes.length}
              postId={post.id}
            />
          </div>
        ))}
      </ul>
    </div>
  );
}

export default GetUserPosts;
