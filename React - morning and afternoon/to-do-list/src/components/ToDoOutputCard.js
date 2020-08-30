import React from 'react'

const ToDoOutputCard = (props) => {
        return <div class="output-card-container">
            <input type="text" className="form-control" value={props.displayText} readOnly/>
            <button class="btn btn-warning" onClick={() => props.handleEdit(props.keyValue)}>Edit</button>
            <button class="btn btn-dark"onClick={() => props.handleDelete(props.keyValue)}>Delete</button>
        </div>
}

export default ToDoOutputCard