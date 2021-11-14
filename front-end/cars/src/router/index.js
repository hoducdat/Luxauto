import { Route, Switch } from "react-router";
import { BrowserRouter } from "react-router-dom";
import { PathConstant } from "../const";
import { CarsStock, Detail, NotFound } from "../pages";

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route
          exact
          path={PathConstant.ROOT}
          render={(matchProps) => <CarsStock {...matchProps} />}
        />
        <Route
          path="/detail/:slug"
          render={(props) => {
            return <Detail props={props} />;
          }}
        />
        <Route exact path={PathConstant.NOT_FOUND} component={NotFound} />
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
