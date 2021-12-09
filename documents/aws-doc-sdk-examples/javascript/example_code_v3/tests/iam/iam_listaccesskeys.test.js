const mockListAccessKeys = jest.fn();
jest.mock("@aws-sdk/client-iam/commands/ListAccessKeysCommand", () => ({
  IAM: function IAM() {
    this.ListAccessKeysCommand = mockListAccessKeys;
  },
}));
const { params, run } = require("../../iam/iam_listaccesskeys.js");

//test function
test("has to mock iam#listAccessKeys", async (done) => {
  await run();
  expect(mockListAccessKeys).toHaveBeenCalled;
  done();
});
