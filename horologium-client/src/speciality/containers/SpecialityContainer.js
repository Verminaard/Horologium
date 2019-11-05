import InputTableFilter from "../../table/elements/filter/input/InputTableFilter";
import ButtonLink from "../../buttons/button-link/ButtonLink";
import PaginationRow from "../../table/elements/pagination/pagination-row/PaginationRow";
import Table from "../../table/containers/table/Table";

import React, { Component } from 'react';
import WithBreadcrumbs from "../../common/components/breadcrumbs/WithBreadcrumbs";


class SpecialityContainer extends Component {
   constructor(props) {
      super(props);

      this.state = {
         pageable: {
            page: 1,
            count: 10
         }
      };

      this.onChangePage = this.onChangePage.bind(this);
      this.onChangeSizePerPage = this.onChangeSizePerPage.bind(this);
      this.loadSpeciality = this.loadSpeciality.bind(this);
   }

   componentDidMount() {
      this.loadSpeciality(this.state.pageable);
   }

   loadSpeciality(pageable) {
      const { requestUserList } = this.props.adminService;
      requestUserList(pageable, filter);
   }

   onChangePage(page) {
      const oldPage = this.state.pageable.page;
      if (oldPage === page) {
         return;
      }
      const newState = update(this.state, {
         pageable: {
            page: { $set: page }
         }
      });
      this.setState(newState);
      this.loadSpeciality(newState.pageable);
   }

   onChangeSizePerPage(sizePerPage) {
      const oldSizePerPage = this.state.pageable.count;
      if (oldSizePerPage === sizePerPage) {
         return;
      }

      const newState = update(this.state, {
         pageable: {
            page: { $set: 1 },
            count: { $set: sizePerPage }
         }
      });
      this.setState(newState);
      this.loadSpeciality(newState.pageable);
   }

   breadcrumbs = [
      {
         home: true,
         link: '/',
         text: 'Главная'
      },
      {
         link: '/admin',
         text: 'Админка'
      },
      {
         active: true,
         text: 'Управление пользователями'
      }
   ];

   render() {
      const {
      } = this.props;
      const { page, count } = this.state.pageable;
      const {
      } = this.state;


      return (
            <WithBreadcrumbs breadcrumbs={this.breadcrumbs} header="Управление пользователями">
               <SpecialityTable specialityData={}/>
            </WithBreadcrumbs>
      );
   }
}

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)();

























const SpecialityContainer = (props) => {
   const {onChangeFilter} = props;

   const data = [
      {
         lastName: "someName",
         firstName: "firstName",
         middleName: "middleName",
         login: "login"
      },
      {
         lastName: "someName2",
         firstName: "firstName2",
         middleName: "middleName2",
         login: "login2"
      },
      {
         lastName: "someName3",
         firstName: "firstName3",
         middleName: "middleName3",
         login: "login3"
      },

   ];

   const columns = [
      {
         key: 'lastName',
         title: 'Фамилия',
         dataFormatter: (item) => item.lastName,
         filter: (
            <InputTableFilter
               name="lastName"
               placeholder="Введите фамилию..."
               onChange={() => ""}
            />
         )
      },
      {
         key: 'firstName',
         title: 'Имя',
         dataFormatter: (item) => item.firstName,
         filter: (
            <InputTableFilter
               name="firstName"
               placeholder="Введите имя..."
               onChange={() => ""}
            />
         )
      },
      {
         key: 'middleName',
         title: 'Отчество',
         dataFormatter: (item) => item.middleName,
         filter: (
            <InputTableFilter
               name="middleName"
               placeholder="Введите отчество..."
               onChange={() => ""}
            />
         )
      },
      {
         key: 'login',
         title: 'Логин',
         dataFormatter: (item) => item.login,
         filter: (
            <InputTableFilter
               name="login"
               placeholder="Введите логин..."
               onChange={() => ""}
            />
         )
      },
      {
         key: 'actions',
         width: '24px',
         className: 'actions',
         dataFormatter: (item) => (
            <span>
               <ButtonLink
                  className="blue"
                  tooltip="Редактировать"
                  icon="fa fa-pencil fa-lg"
                  href={`/admin/users/edit/`}
               />
            </span>
         )
      }
   ];

   const pagination = (
      <PaginationRow
         page={1}
         sizePerPage={10}
         itemCount={100}
      />
   );

   return (
      <Table
         dataList={data}
         paginationRow={pagination}
         filterableTable
         columns={columns}
      />
   );
};

export default SpecialityContainer;
