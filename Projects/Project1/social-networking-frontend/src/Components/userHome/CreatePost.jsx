import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { useState } from "react";
import postCreatePost from "./postCreatePost";

function CreatePost() {
  const [content, setContent] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("submitted data: ", content);
    postCreatePost(content);
    setContent("");
  };
  return (
    <>
      <Card>
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formFile" className="mb-3">
            <Form.Label>Upload a picture</Form.Label>
            <Form.Control type="file" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formTitle">
            <Form.Label>Caption</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter caption"
              value={content}
              onChange={(e) => setContent(e.target.value)}
            />
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </Card>
    </>
  );
}

export default CreatePost;
