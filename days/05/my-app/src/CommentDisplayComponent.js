
const CommentDisplayComponent = ({comments, handleDelete}) => {
    return (
        <>
        <h2>Comments</h2>
        {comments.map( (comment) => (
            <div key={comment.id}>
                <p>{comment.name}</p>
                <button onClick={() => handleDelete(comment.id)}>Delete</button>
            </div>
        ))}
        </>
    )
}

export default CommentDisplayComponent;