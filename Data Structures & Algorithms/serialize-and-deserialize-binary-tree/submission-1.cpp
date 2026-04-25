class Codec {
    struct BitWriter {
        string s;
        int bit = 0;

        void writeBit(int x) {
            if (bit == 0) s.push_back(0);
            if (x) s.back() |= char(1 << bit);
            bit = (bit + 1) & 7;
        }

        void writeInt(int x) {
            unsigned int v = (unsigned int)x;
            for (int i = 0; i < 32; i++) {
                writeBit((v >> i) & 1);
            }
        }
    };

    struct BitReader {
        const string& s;
        int idx = 0;
        int bit = 0;

        BitReader(const string& data) : s(data) {}

        int readBit() {
            int x = ((unsigned char)s[idx] >> bit) & 1;
            bit++;
            if (bit == 8) {
                bit = 0;
                idx++;
            }
            return x;
        }

        int readInt() {
            unsigned int v = 0;
            for (int i = 0; i < 32; i++) {
                if (readBit()) v |= (1u << i);
            }
            return (int)v;
        }
    };

    void writeTree(TreeNode* node, BitWriter& bw) {
        if (!node) {
            bw.writeBit(0);
            return;
        }

        bw.writeBit(1);
        bw.writeInt(node->val);
        writeTree(node->left, bw);
        writeTree(node->right, bw);
    }

    TreeNode* readTree(BitReader& br) {
        if (!br.readBit()) return nullptr;

        TreeNode* node = new TreeNode(br.readInt());
        node->left = readTree(br);
        node->right = readTree(br);

        return node;
    }

public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        BitWriter bw;
        writeTree(root, bw);
        return bw.s;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        BitReader br(data);
        return readTree(br);
    }
};