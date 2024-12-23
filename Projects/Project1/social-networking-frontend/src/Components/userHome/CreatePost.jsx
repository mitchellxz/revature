import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

function CreatePost() {
  return (
    <>
      <Card>
        <Form>
          <Form.Group controlId="formFile" className="mb-3">
            <Form.Label>Upload a picture</Form.Label>
            <Form.Control type="file" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formTitle">
            <Form.Label>Caption</Form.Label>
            <Form.Control type="text" placeholder="Enter caption" />
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
