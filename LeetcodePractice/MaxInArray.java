void main() throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
        int N = sc.nextInt();
        int max = 0;
        for (int i = 0; i < N; i++) {

            int maxNumber = sc.nextInt();
            if (maxNumber > max) {
                max = maxNumber;
            }
        }
        IO.println(max);

    }
}
