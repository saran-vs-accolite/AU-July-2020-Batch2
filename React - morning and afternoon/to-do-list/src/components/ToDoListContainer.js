import React, { useState } from 'react'
import ToDoInput from './ToDoInput'
import uuid from 'uuid/dist/v1'
import ToDoOutput from './ToDoOutput'

const ToDoListContainer = () => {
    const [toDoItems, setItems] = useState([])
    const [isEdit, setIsEdit] = useState(false)
    const [newItem, setNewItem] = useState('')


    const handleDelete = (givenUUID) => {
        const postDeleteItems = toDoItems.filter(item => item.id !== givenUUID)
        setItems(postDeleteItems)
    }

    const handleInsert = (text) => {
        setItems([ {id: uuid(), content: text}, ...toDoItems])
        setNewItem('')
        if(isEdit === true)
           setIsEdit(false) 
    }

    const handleEdit = (givenUUID) => {
        const editItem = toDoItems.filter((item) => item.id === givenUUID)[0]
        console.log(editItem)
        setNewItem(editItem.content)
        handleDelete(givenUUID)
        setIsEdit(true)
    }

    const handleClearList = () => {
        setItems([])
    }
    
    return (
        <div class="to-do-container">
            <ToDoInput newItem={newItem} isEdit={isEdit} handleInsert={handleInsert}/>
            <ToDoOutput items={toDoItems} handleDelete={handleDelete} handleEdit={handleEdit}/>
            <button className="btn btn-danger btn-long clear" onClick={handleClearList}>Clear List</button>
        </div>
    )
}

export default ToDoListContainer