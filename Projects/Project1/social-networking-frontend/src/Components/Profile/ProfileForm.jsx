import Button from "react-bootstrap/Button";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import Form from "react-bootstrap/Form";
import editProfile from "./editProfile";
import { useState } from "react";

const ProfileForm = () => {
  const [name, setName] = useState("");
  const [bio, setBio] = useState("");
  const [location, setLocation] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("submitted data: ", { name, bio, location });
    editProfile(name, bio, location);
    setName("");
    setBio("");
    setLocation("");
  };
  return (
    <Form onSubmit={handleSubmit}>
      <FloatingLabel controlId="floatingInput" label="Name" className="mb-3">
        <Form.Control
          type="text"
          placeholder="John Smith"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </FloatingLabel>

      <FloatingLabel controlId="floatingInput" label="Bio" className="mb-3">
        <Form.Control
          type="text"
          placeholder="Bio"
          value={bio}
          onChange={(e) => setBio(e.target.value)}
        />
      </FloatingLabel>

      <FloatingLabel
        controlId="floatingInput"
        label="Location"
        className="mb-3"
      >
        <Form.Control
          type="text"
          placeholder="USA"
          value={location}
          onChange={(e) => setLocation(e.target.value)}
        />
      </FloatingLabel>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default ProfileForm;
