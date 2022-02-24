import java.util.HashMap;
import java.util.function.Consumer;

 class SwitchHelper<T> {

    T object;

    public SwitchHelper(T object) {
        this.object = object;
    }

    protected HashMap<String,Consumer<T> > map = new HashMap<>();

    public  void addMethod(String str,Consumer<T> consumer) {
        map.put(str,consumer);
    }

    public boolean execute(String str) {

        if(map.containsKey(str)) {
            map.get(str).accept(object);
            return  true;
        }
        return false;
    }


}
class PolicyCommandGF {


    public void performExtraAction(String subActionName) {
        try {
            SubActions subActions = SubActions.valueOf(subActionName);
            subActions.policyCommandGFConsumer.accept(this);
        }catch (IllegalArgumentException e){
            //super.performExtraAction(subActionName);
            System.out.println("call core");
        }

    }



    public enum SubActions {
        Action1(PolicyCommandGF::action1),
        Action2(PolicyCommandGF::action2),
        Action3(PolicyCommandGF::action3),
        Action4(PolicyCommandGF::action4),
        Action5(PolicyCommandGF::action5),
        newAction(PolicyCommandGF::newAction);
        public final Consumer<PolicyCommandGF> policyCommandGFConsumer;
        private SubActions(Consumer<PolicyCommandGF> policyCommandGFConsumer){
            this.policyCommandGFConsumer=policyCommandGFConsumer;
        }
    }

    private  void newAction( ) {
        System.out.println("new Action");
    }


    public  void action1() {

        System.out.println("Action 1");

    }

    public  void action2()  {

        System.out.println("Action 2"  );

    }

    private  void action3() {

        System.out.println("Action 3"  );
    }

    public  void action4()  {

        System.out.println("Action 4"  );

    }

    public  void action5()  {

        System.out.println("Action 5"  );

    }



}

public class main {

    public static void main(String[] args) {



        commandRefactoring();

        switchRefactoring("MOBILE");

    }

    private static void commandRefactoring() {
        PolicyCommandGF policyCommandGF = new PolicyCommandGF();
        policyCommandGF.performExtraAction("newAction");
    }


    private static void switchRefactoring(String value)  {

        Customer customer= new Customer();
/* OLD WAY
        switch (value) {

            case "ID":
                customer.buildId();
                break;
            case "MOBILE": customer.buildMobile();
                break;
            case "NAME": customer.buildName();
                break;
            default: System.out.println("call core");

        }
**/
        SwitchHelper<Customer> customerSwitchHelper = new SwitchHelper<>(customer);
        customerSwitchHelper.addMethod("ID", Customer::buildId);
        customerSwitchHelper.addMethod("MOBILE", Customer::buildMobile);
        customerSwitchHelper.addMethod("NAME", Customer::buildName);

        customerSwitchHelper.execute(value);




    }
}
