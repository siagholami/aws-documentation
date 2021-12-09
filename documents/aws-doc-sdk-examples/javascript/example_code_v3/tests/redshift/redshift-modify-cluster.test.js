const mockModifyCluster = jest.fn();
jest.mock("@aws-sdk/client-redshift-node", () => ({
    Redshift: function Redshift() {
        this.ModifyClusterCommand = mockModifyCluster;
    },
}));
const { run } = require("../../redshift/redshift-create-cluster");

//test function
test("has to mock RedShift#modifyClusters", async (done) => {
    await run();
    expect(mockModifyCluster).toHaveBeenCalled;
    done();
});
