const CommentsComponent = ({comments}) => {
    return (
        <>
        {comments.map((comment, index) => (
            <p key={index}>{comment}</p>
        ))}
        </>
    )
}

export default CommentsComponent;