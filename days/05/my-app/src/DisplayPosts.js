const DisplayPosts = ({posts}) => {
    return (
        <>
        {
            posts.map((post) => (
                <div key={post.id}>
                    <h3>{post.id}</h3>
                    <p>{post.title}</p>
                    <br />
                </div>
            ))
        }
        </>
    );
}

export default DisplayPosts;