import Card from "react-bootstrap/Card";
import placeholder from "./192x_placeholder.png";
import PostCommentForm from "./PostCommentForm";
import Button from "react-bootstrap/Button";
import likePost from "./likePost";

function CardPostComponent({
  name,
  postTitle,
  messages,
  postDate,
  likes,
  postId,
}) {
  const handleSubmit = async (e) => {
    e.preventDefault();
    await likePost(postId);
  };
  return (
    <Card className="text-center">
      <Card.Header>{name}</Card.Header>
      <Card.Img src={placeholder} />
      <Card.Title>{postTitle}</Card.Title>
      <Card.Body>
        <Button onClick={handleSubmit} variant="dark" size="sm">
          Like
        </Button>
        <PostCommentForm postId={postId} />
        {messages?.map((message) => (
          <p key={message.id}>{message.messageText}</p>
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
