public class Hancom2 {

	public static void main(String[] args) {

		String acgtSequence = "ACCGGCCGAGACAGCGAGCATATGCCGCCGAGACAGGCCGGACCGGCCGAGA";
		String codon = "GCCG";

		// ������ ��ü�� ��ȸ
		for (int i = 0; i < acgtSequence.length(); i = i + 1) {
			// �ϳ��� ���ڸ� ch�� ����
			char ch = acgtSequence.charAt(i);
			// ch�� codon�� ù��° ���ڰ� ���ٸ�
			if (ch == codon.charAt(0)) {
				// ��ġ�� ����
				int idx = i;
				// codon�� �ι�° ���ں��� ������ ��
				int j;
				for (j = 1; j < codon.length(); j = j + 1) {
					// ���� �ٸ� ���ڰ� ���´ٸ� �ݺ��� ����
					ch = acgtSequence.charAt(idx + j);
					if (ch != codon.charAt(j)) {
						break;
					}
				}
				// �ݺ����� ���������� ����Ǿ��ٸ�
				// ��� ���ڰ� �����ϴٸ�
				if (j == codon.length()) {
					System.out.println(idx);
					i = i + codon.length() - 1;
				}

			}

		}

	}

}
