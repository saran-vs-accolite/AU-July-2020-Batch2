import React from 'react'
import ToDoOutputCard from './ToDoOutputCard'

const ToDoOutput = (props) => {
        return <div style={{marginTop:10 + 'em'}}>
            <h3>To Do List</h3>
            {props.items.map((item) => <ToDoOutputCard key={item.id} displayText={item.content} keyValue={item.id} handleDelete={props.handleDelete} handleEdit={props.handleEdit}/>)}
        </div>
}

export default ToDoOutput