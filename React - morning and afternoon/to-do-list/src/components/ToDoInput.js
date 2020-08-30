import React, { Component } from 'react'

class ToDoInput extends Component {
    constructor(props) {

        super(props)

        this.state = {
            textBoxValue: '',
            textBoxValueProp: ''
        }
    }

    handleTextBoxInputChange = (event) => {
        this.setState({ textBoxValue: event.target.value });
    }

    static getDerivedStateFromProps(props, state) {
        if (props.newItem !== state.textBoxValueProp) {
            return {
                textBoxValue: props.newItem,
                textBoxValueProp: props.newItem
            };
        }
        else
            return null;
    }

    handleButtonClick = () => {
        const insertValue = this.state.textBoxValue
        this.setState({ textBoxValue: '' })
        this.props.handleInsert(insertValue)
    }

    render() {
        let button;

        if (this.props.isEdit === false)
            button = <button className="btn btn-primary btn-long" onClick={this.handleButtonClick}> Add </button>
        else
            button = <button className="btn btn-success btn-long" onClick={this.handleButtonClick}> Edit </button>

        return <div className="to-do-input-container">
            <h3>To Do Input</h3>
            <div>
                <input type="text" className="form-control" onChange={this.handleTextBoxInputChange} value={this.state.textBoxValue} />
            </div>
            <div>
                {button}    
            </div>
            
        </div>
    }
}

export default ToDoInput