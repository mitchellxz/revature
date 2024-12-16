import { Link } from "react-router-dom"

const Navbar = () => {
    return (
        <div className="navbar">
            <h2>The React Demos</h2>
            <div className="links">
                <Link to="/Hello">Hello</Link>
                <Link to="/sdc">State Demo</Link>
                <Link to="/edc">Event Demo</Link>
                <Link to="/getposts">Posts</Link>
                <Link to="/createpost">Add Post</Link>
                <Link to="/updatepost">Update Post</Link>
                <Link to="/patchpost">Patch Post</Link>
                <Link to="/deletepost">Delete Post</Link>
            </div>
        </div>
    );
}

export default Navbar;