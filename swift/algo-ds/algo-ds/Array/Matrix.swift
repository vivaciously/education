//
//  Matrix.swift
//  algo-ds
//
//  Created by Shin on 2021/10/23.
//

import Foundation

struct Matrix<T> {
    public let rows: Int
    public let cols: Int
    private var items: [T?]
    
    public var count: Int {
        var res = 0
        for i in 0 ..< rows * cols {
            if items[i] != nil {
                res += 1
            }
        }
        return res
    }
    
    public init(rows: Int, cols: Int) {
        self.rows = rows
        self.cols = cols
        items = Array(repeating: nil, count: rows * cols)
    }
    
    public init(rows: Int, cols: Int, defaultValue: T) {
        self.rows = rows
        self.cols = cols
        items = Array(repeating: defaultValue, count: rows * cols)
    }
    
    public mutating func clearAll() {
        for i in 0 ..< rows * cols {
            items[i] = nil
        }
    }
    
    public func isIndexValid(row: Int, col: Int) -> Bool {
        row >= 0 && row < rows && col >= 0 && col < cols
    }
    
    public subscript(row: Int, col: Int) -> T? {
        get {
            assert(isIndexValid(row: row, col: col), "Index Out of Range.")
            return items[cols * row + col]
        }
        set {
            assert(isIndexValid(row: row, col: col), "Index Out of Range.")
            items[cols * row + col] = newValue
        }
    }
    
}
