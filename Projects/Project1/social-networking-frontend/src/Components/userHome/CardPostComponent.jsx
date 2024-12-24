import Card from "react-bootstrap/Card";
import placeholder from "./placeholder_2.jpg";
import PostCommentForm from "./PostCommentForm";
import Button from "react-bootstrap/Button";
import likePost from "./likePost";
import unlikePost from "./unlikePost";

function CardPostComponent({
  name,
  postTitle,
  messages,
  postDate,
  likes,
  postId,
}) {
  const handleSubmitLike = async (e) => {
    e.preventDefault();
    await likePost(postId);
  };
  const handleSubmitUnlike = async (e) => {
    e.preventDefault();
    await unlikePost(postId);
  };
  return (
    <Card className="card-post">
      <Card.Header>{name}</Card.Header>
      <Card.Img src={placeholder} />
      <Card.Title>{postTitle}</Card.Title>
      <Card.Body>
        <Button
          className="post-button"
          onClick={handleSubmitLike}
          variant="dark"
          size="sm"
        >
          Like
        </Button>
        <Button
          className="post-button"
          onClick={handleSubmitUnlike}
          variant="dark"
          size="sm"
        >
          Unlike
        </Button>
        <PostCommentForm postId={postId} />
        {messages?.map((message) => (
          <div key={message.id}>
            {message.messageText}
            <hr />
          </div>
        ))}
      </Card.Body>
      <Card.Footer>
        <small className="text-muted">likes: {likes}</small>
        <br />
        <small className="text-muted">{postDate}</small>
      </Card.Footer>
    </Card>
  );
}

export default CardPostComponent;
