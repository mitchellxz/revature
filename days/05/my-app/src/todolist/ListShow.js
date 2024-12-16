const ListShow = ({list}) => {
    return (
        <div>
            <h3> To Do List</h3>
            {
                list.map( (item) => (
                    <li key={item}>{item}</li>
                ))
            }
        </div>
    );
}

export default ListShow;