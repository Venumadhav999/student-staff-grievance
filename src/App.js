import {  Routes, Route } from 'react-router-dom';
import ComplaintsDisplay from './components/Display/ComplaintsDisplay';
import ComplaintForm from './components/complaint/ComplaintForm';
import Home from './components/Start/Home';
import StudentLogin from './components/StudentAuth/StudentLogin';
import StaffLogin from './components/StaffAuth/StaffLogin';
import HODLogin from './components/HodAuth/HODLogin';
import ComplaintsByDepartment from './components/Display/ComplaintsByDepartment';
import ManagementLogin from './components/MangAuth/ManagementLogin';


function App() {

  return (
    
    
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/complaint-form" element={<ComplaintForm />} />
      <Route path="/complaints-display" element={<ComplaintsDisplay />} />
      <Route path="/studentlogin" element={<StudentLogin/>}/>
      <Route path="/stafflogin" element={<StaffLogin/>}/>
      <Route path="/hodlogin"  element={<HODLogin />}/>
      <Route path="/deptcomplaints/:department" element={<ComplaintsByDepartment/>}/>
      <Route path="/manglogin" element={<ManagementLogin/>}/>
    </Routes>
    
  );
}

export default App;