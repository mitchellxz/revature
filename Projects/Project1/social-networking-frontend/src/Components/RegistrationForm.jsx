import { useState } from "react";

function RegistrationForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const registrationData = {
      username: username,
      password: password,
    };

    try {
      const response = await fetch(
        "http://localhost:8080/api/account/register",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(registrationData),
        }
      );
      if (!response.ok) {
        const errorMessage = await response.text();
        alert(errorMessage);
      } else {
        setUsername("");
        setPassword("");
        alert("Successfully registered.");
      }
    } catch (error) {
      console.error("Error registrating: ", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Username: </label>
        <input
          type="text"
          id="username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div>
        <label>Password: </label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div>
        <button type="submit">Register</button>
      </div>
    </form>
  );
}

export default RegistrationForm;
