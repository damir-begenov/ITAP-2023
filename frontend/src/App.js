import React, { lazy, Suspense } from "react";
import './App.css';
// import './Loader.css'
// import './fonts/font.css'
// import './fonts/montserrat.css'
// import './fontawesome/all.css';
import { Dashboard } from "superset-dashboard-sdk";
import { embedDashboard } from "@superset-ui/embedded-sdk";

import Navbar from './Components/NavBar/Navbar';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import {motion} from 'framer-motion';
import axios from "axios";

// import GraphNet from './pages/Graphs/Graphs';
// import MainPage from './pages/MainPage/MainPage';
// import RegistrationPage from './pages/Registration/RegistrationPage';
// import SignInPage from './pages/SignIn/SignInPage';
// import AdminPage from './pages/AdminPage/AdminPage';
// import TableLog from './Components/TableLog/TableLog';
// import UsersTable from './Components/UsersTable/UsersTable';
// import UserDetails from './pages/userDetails/userDetails';
const baseURL = "http://localhost:9091/api/finpol/main"

const App = () => {
  const GraphNet = lazy(() => import('./pages/Graphs/Graphs'));
  const RegistrationPage = lazy(() => import('./pages/Registration/RegistrationPage'));
  const SignInPage = lazy(() => import('./pages/SignIn/SignInPage'));
  const AdminPage = lazy(() => import('./pages/AdminPage/AdminPage'));
  const TableLog = lazy(() => import('./Components/TableLog/TableLog'));
  const UserDetails = lazy(() => import('./pages/userDetails/userDetails'));

  const userSession = JSON.parse(localStorage.getItem("user"))
  return (
    <Router>
      <div className='App'>
        <div>

        </div>
        <Routes>

          <Route path="/" element={
            <>
              <Navbar/>

                <Suspense fallback={<span class="loader"></span>}>
                  <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
                    <GraphNet />

                  </motion.div>
                </Suspense>
            </>
          } />
          <Route path="/registration" element={
            <>

              <Navbar/>
                <Suspense fallback={<span class="loader"></span>}>
                  <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
                    <RegistrationPage/>
                  </motion.div>
                </Suspense>
            </>
          } />

          <Route path="/login" element={
            <>
              <Suspense fallback={<span class="loader"></span>}>
                <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
                  <SignInPage />
                </motion.div>
              </Suspense>
            </>
          } />
          {console.log(userSession)}
          <Route path="/table" element={
            <>
              {/* {!userSession ? navigate('/login', {replace: true}) : ""}  */}
              <Navbar/>
              <Suspense fallback={<span className="loader"></span>}>
              <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
              <TableLog/>
                  </motion.div>
              </Suspense>
            </>
          } />
          <Route path="/admin" element={
                <>
                  <Navbar/>
                  <Suspense fallback={<span class="loader"></span>}>
                    <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
                      <AdminPage/>
                    </motion.div>
                  </Suspense>
                </>
              }/>
          <Route path="/users/:username" element={
            <>
              <Navbar/>
              <Suspense fallback={<span class="loader"></span>}>
                <motion.div initial={{opacity: 0}} animate={{opacity: 1}} transition={{ duration: 0.2 }}>
                  <UserDetails/>
                </motion.div>
              </Suspense>
            </>
          }/>
          {/* <Route path="/userTable" element={<UsersTable/>} /> */}
          {userSession
          && userSession.roles[0] == "ADMIN"
            ? (
              <>
              </>
            ) : (
              <>

              </>
            )
          }
        </Routes>
      </div>
    </Router>

  )
}

export default App;
