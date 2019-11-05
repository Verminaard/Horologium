import React, { Component, Fragment } from 'react';
import navListItems from './const/navbar/navListItems';

import logoImg from './assets/img/horoLogo.png';
import Navbar from "./common/components/header/Navbar";
import NotificationContainer from "./common/components/notifications/NotificationContainer";
import {Route, Switch} from "react-router-dom";
import SpecialityContainer from "./speciality/containers/SpecialityContainer";
import LandingPage from "./landingPage/LandingPage";

class App extends Component {
   constructor(props, context) {
      super(props, context);
      this.setActiveItem = this.setActiveItem.bind(this);
   }

   setActiveItem(navListItem) {
      const pathname = this.props.location.pathname;
      return navListItem.map((item) => ({...item, isActive: (pathname === item.href)}));
   }

   render() {
      const logo = {
         image: {
            className: "main-logo",
            source: logoImg
         }
      };

      return (
         <div>
            <Navbar logo={logo} navbarTabs={this.setActiveItem(navListItems)} />
            <Switch>
               <Fragment>
                  <Route exact path="/" component={LandingPage} />
                  <Route exact path="/doctors" component={<h>nothing</h>} />
                  <Route exact path="/speciality" component={SpecialityContainer} />
               </Fragment>
            </Switch>
            <NotificationContainer/>
         </div>
      );
   }
}

export default App;
