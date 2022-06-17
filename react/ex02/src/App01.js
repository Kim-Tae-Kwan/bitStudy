import React from "react";

export default class App01 extends React.Component{
    constructor(props){
        super(props);
        console.log(props);
        this.props = props;
    }

    clickFunc(){
        console.log("method...", this.props);
    };

    render() {
        return (
            <>
                <h1>ClASS 형 이벤트</h1>
                <button onClick={() => {console.log("람다", this.props);}}>click1</button>
                <button onClick={(function() {console.log("function", this.props);}).bind(this)}>click2</button>
                <button onClick={this.clickFunc.bind(this)}>click3</button>
            </>
        );
    }
}