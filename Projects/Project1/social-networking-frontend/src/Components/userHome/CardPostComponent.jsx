import Card from "react-bootstrap/Card";
import placeholder from "./192x_placeholder.png";

function CardPostComponent({ name, postTitle, messages, postDate, likes }) {
  return (
    <Card className="text-center">
      <Card.Header>{name}</Card.Header>
      <Card.Img src={placeholder} />
      <Card.Body>
        <Card.Title>{postTitle}</Card.Title>
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
