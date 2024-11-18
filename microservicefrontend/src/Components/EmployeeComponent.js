import React from 'react';
// import PropTypes from 'prop-types';
import EmployeeService from '../Services/EmployeeService';

class EmployeeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employee:{},
            department:{},
            organization:{}
        };
    }
    
    /*
    * The below is the React Class component lifecycle method used instead of the UseEffect inside functional
      component.
    * Using this method to make the rest api call and get the data making the rest api call 
    * This method will get called whenever this component will get mounted  
    *  componentDidMount(){
    (async ()=>{
        const data= await EmployeeService.getEmployee();
    data.then((response)=>{
        // console.log(response)
        this.setState({employee : response.data.employee})
         this.setState({department : response.data.department})
          this.setState({organization : response.data.organization})
          
    })
    })
    
    console.log(this.state.employee);
          console.log(this.state.department);
          console.log(this.state.organization);
}    
    */
    async componentDidMount() {
    try {
        const response = await EmployeeService.getEmployee();
        
        // Set the state with the response data
        this.setState({
            employee: response.data.employee,
            department: response.data.department,
            organization: response.data.organization
        });
    } catch (error) {
        console.error('Error fetching employee data:', error);
    }
}

// Use componentDidUpdate to log the updated state after it's changed
componentDidUpdate(prevProps, prevState) {
    if (prevState.employee !== this.state.employee) {
        console.log('Updated employee:', this.state.employee);
    }
    if (prevState.department !== this.state.department) {
        console.log('Updated department:', this.state.department);
    }
    if (prevState.organization !== this.state.organization) {
        console.log('Updated organization:', this.state.organization);
    }
//     if (!employee || !department || !organization) {
//   return <div>Loading...</div>;
// }

}
    
    render() {
        // The below we can see the JSX code which we are going to use across
        return (
            <div> <br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong> {this.state.employee.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Last Name: </strong> {this.state.employee.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Email: </strong> {this.state.employee.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong> {this.state.department.departmentName }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Description: </strong> {this.state.department.departmentDescription }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong> {this.state.department.departmentCode }</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Organization Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong> Organization Name: </strong> {this.state.organization.organizationName } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Description: </strong> {this.state.organization.organizationDescription } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Code: </strong> {this.state.organization.organizationCode } </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

// EmployeeComponent.propTypes = {};

export default EmployeeComponent;
