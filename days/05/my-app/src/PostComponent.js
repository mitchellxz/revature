import CommentsComponent from './CommentsComponent';
import './PostComponent.css';

const PostComponent = (props) => {
    const {comments} = props;
    
    return(
        <div class="post">
        <h1>Post</h1>
        <CommentsComponent comments={comments} />
        </div>
   
    );

}

export default PostComponent;