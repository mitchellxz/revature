import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useState } from "react";
import postComment from "./postComment";

function PostCommentForm({ postId }) {
  const [comment, setComment] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("submitted data: " + comment);
    await postComment(comment, postId);
    setComment("");
  };

  return (
    <Form onSubmit={handleSubmit} className="comment-form">
      <Form.Group className="mb-3">
        <Form.Control
          as="textarea"
          rows={2}
          placeholder="Leave a comment"
          value={comment}
          onChange={(e) => setComment(e.target.value)}
        />
      </Form.Group>
      <Button variant="dark" type="submit">
        Reply
      </Button>
    </Form>
  );
}

export default PostCommentForm;
