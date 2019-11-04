import React, { Component } from 'react';
import navListItems from './const/navbar/navListItems';

import logoImg from './assets/img/horoLogo.png';
import Navbar from "./common/components/header/Navbar";
import NotificationContainer from "./common/components/notifications/NotificationContainer";

class App extends Component {
   constructor(props, context) {
      super(props, context);
      this.setActiveItem = this.setActiveItem.bind(this);
   }

   setActiveItem(navListItem) {
      const pathname = this.props.location;
      navListItem.map((item) => ({...item, isActive: (pathname === item.href)}));

      return navListItem;
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
            <NotificationContainer/>
         </div>
      );
   }
}

export default App;
